package File;

import core.FileUtil;

import java.io.File;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

import static java.lang.System.getProperty;

public class Leason01_ReadAFile {
    public static void main(String[] args) throws Exception{
        Properties testManagerProperties = new Properties();
        // String RESOURCE_FOLDER_PATH;

        // // System.out.println("Loading MySQL JDBC driver");
        // Object deviceTokenFileFolderPath = testManagerProperties.setProperty("resources", currentFolder.getAbsolutePath() + "/src/main/resources");

        // folder chứa code
        File currentFolder = new File(getProperty("user.dir"));
        String randomIdGeoFence = String.valueOf(UUID.randomUUID());
        String createdRuleName = "NAME" + UUID.randomUUID();
        // đường dẫn đến file .json
        String RESOURCE_PATH =  currentFolder.getAbsolutePath() + "/src/File";
        // replace 1 đoạn text trong file json
        String jsonPayloadString = Objects.requireNonNull(FileUtil.fileContentsToString(RESOURCE_PATH + "/geofence_rule.json"))
                .replace("NAME", createdRuleName).replace("GEOFENCE_ID", randomIdGeoFence);
        // khai báo 1 file tạm
        File temporaryFile = new File(RESOURCE_PATH + String.format("/temp_file_%s.json", UUID.randomUUID().toString().split("-")[0]));
        // viết file json đã replace new text và file tạm
        FileUtil.writeToFile(temporaryFile,jsonPayloadString);
        // delete file
        FileUtil.deleteFile(temporaryFile);

    }
}
