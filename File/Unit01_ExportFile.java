package File;


import org.apache.log4j.Logger;

import java.io.File;

public class Unit01_ExportFile {


    protected static Logger LOGGER ;



    public static void main(String[] args) throws Exception {

        // verifyExportFile("Operating System", CSV_WITH_COLUMN_NAMES);


    }
     public static void verifyExportFile(String reportName, EXPORT_FORMAT format) throws Exception {
        LOGGER.info("Verify Export File");
        File dir = new File(System.getProperty("user.home") + "//Automation2-distribution//");
        String endWith;
        switch(format) {
            case CSV_WITH_COLUMN_NAMES:
            case CSV_WITHOUT_COLUMN_NAMES:
                endWith = ".csv";
                break;
            case EXCEL:
                endWith = ".xlsx";
                break;
            case XML:
                endWith = ".xml";
                break;
            default:
                throw new RuntimeException("Invalid format");
        }

        File[] foundFiles = dir.listFiles((dirr, name) -> {
            return name.startsWith(reportName);
        });
        File[] allFiles = dir.listFiles();
        if (foundFiles == null) {
            throw new Exception("Unable to get any export files under location: " + dir.getAbsolutePath());
        } else {
            // LOGGER.info("debug report download directory {} ...", dir.getAbsolutePath());
            // LOGGER.info("foundFiles array size {}", foundFiles.length);
            // LOGGER.info("allFiles array size {}", allFiles.length);
            File fileFound = null;
            File[] var9 = foundFiles;
            int var10 = foundFiles.length;

            int var11;
            File file;
            for(var11 = 0; var11 < var10; ++var11) {
                file = var9[var11];
                // LOGGER.info("file path: {}", file);
                if (file.getName().endsWith(endWith) && System.currentTimeMillis() - file.lastModified() <= 30000L) {
                    fileFound = file;
                    break;
                }
            }

            if (allFiles != null) {
                var9 = allFiles;
                var10 = allFiles.length;

                for(var11 = 0; var11 < var10; ++var11) {
                    file = var9[var11];
                    // LOGGER.info("file path: {}", file);
                }
            }

            if (fileFound == null || !fileFound.getName().endsWith(endWith)) {
                throw new Exception("Cannot find the export report: " + reportName);
            }
        }
    }


    public enum EXPORT_FORMAT {
        CSV_WITH_COLUMN_NAMES,
        CSV_WITHOUT_COLUMN_NAMES,
        XML,
        EXCEL;

        private EXPORT_FORMAT() {
        }
    }


}
