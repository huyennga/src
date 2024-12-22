package com.absolute.qa.automation.mt.project.licenseassignmentsettings.buybacklicense;

import java.util.ArrayList;
import java.util.List;

public class Stream03 {
    public void main(String[] args) {
        // Sample data
        List<AccountLicense> accountLicenseBefore = List.of(
                new AccountLicense("1"),
                new AccountLicense("2"),
                new AccountLicense("3")
        );

        List<AccountLicense> accountLicenseAfter = List.of(
                new AccountLicense("2"),
                new AccountLicense("3"),
                new AccountLicense("4")
        );

        // Using a for loop to find the difference
        List<AccountLicense> diffAccountLicense = new ArrayList<>();
        diffAccountLicense = accountLicenseAfter.stream() .filter(aAfter -> accountLicenseBefore.stream().noneMatch(aBefore -> aBefore.getId().equals(aAfter.getId()))) .toList();
    }


    static class AccountLicense {
        private String id;

        public AccountLicense(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "AccountLicense{id='" + id + "'}";
        }
    }
}
