//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class FileUtil {
    private static final Logger logger = LogManager.getLogger(FileUtil.class.getSimpleName());

    public FileUtil() {
    }

    public static void mergeMultipleFiles(File dir, File destFile, String extension) throws AutomationException {
        File[] files = getFilesByExtension(dir, extension);
        combineAndWriteToFile(files, destFile);
    }

    private static void combineAndWriteToFile(File[] files, File destFile) throws AutomationException {
        ArrayList lines = new ArrayList();

        try {
            File[] var3 = files;
            int var4 = files.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                File file = var3[var5];
                lines.addAll(Files.readAllLines(Paths.get(file.toURI())));
            }

            StringBuffer sb = new StringBuffer();
            lines.forEach((line) -> {
                sb.append(line).append("\n");
            });
            writeToFile(destFile, sb.toString());
        } catch (Exception var7) {
            throw new AutomationException(var7);
        }
    }

    private static File[] getFilesByExtension(File dir, final String extension) {
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File file, String name) {
                return name.endsWith(extension);
            }
        };
        return dir.listFiles(filter);
    }

    public static void writeToFile(File file, String content) throws AutomationException {
        try {
            createParentFolder(file);
            FileUtils.writeStringToFile(file, content, "UTF-8");
        } catch (IOException var3) {
            throw new AutomationException("Failed to write file %s.", var3, new Object[]{file.getAbsolutePath()});
        }
    }

    public static void writeToFile(String filename, String content) throws AutomationException {
        File file = new File(filename);
        writeToFile(file, content);
    }

    public static void createParentFolder(File file) {
        File folder = file.getParentFile();
        if (!folder.exists()) {
            folder.mkdirs();
        }

    }

    public static Map<String, Object> getDataMapFromFile(File file) throws AutomationException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = (Map)mapper.readValue(file, new TypeReference<Map<String, Object>>() {
            });
            return map;
        } catch (Exception var3) {
            throw new AutomationException(var3);
        }
    }

    public static int countFileLines(String filename) throws AutomationException {
        int count = 0;
        File file = new File(filename);
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);

                try {
                    for(LineNumberReader lnr = new LineNumberReader(fr); lnr.readLine() != null; ++count) {
                    }
                } catch (Throwable var7) {
                    try {
                        fr.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }

                    throw var7;
                }

                fr.close();
            } catch (IOException var8) {
                throw new AutomationException("Failed to count line of the file %s.", new Object[]{filename});
            }

            logger.info(String.format("Total number of lines : {}", count));
            return count;
        } else {
            logger.info(String.format("File {} does not exists!", filename));
            return -1;
        }
    }

    public static void deleteFile(String targetFilename) throws AutomationException {
        File targetFile = new File(targetFilename);
        deleteFile(targetFile);
    }

    public static void deleteFile(File targetFile) throws AutomationException {
        if (targetFile.exists()) {
            try {
                if (targetFile.delete()) {
                    logger.info(String.format("File: {} is deleted.", targetFile.getName()));
                } else {
                    logger.info(String.format("Failed to delete file: {}.", targetFile.getName()));
                }
            } catch (SecurityException var2) {
                logger.info(String.format("Error occurs when deleting file {}", var2, targetFile.getName()));
            }
        } else {
            logger.info(String.format("File: {} does not exists.", targetFile.getName()));
        }

    }

    public static void copyFileToFolder(File file, File folder) throws AutomationException {
        String filePath = file.getAbsolutePath();
        String folderPath = folder.getAbsolutePath();

        try {
            folder.mkdirs();
            Files.copy(Paths.get(filePath), Paths.get(folderPath).resolve(file.getName()));
        } catch (SecurityException var5) {
            throw new AutomationException("Failed to create folder %s.", var5, new Object[]{folderPath});
        } catch (IOException var6) {
            throw new AutomationException("Failed to copy %s to %s.", var6, new Object[]{filePath, folderPath});
        }
    }

    public static void zipSingleFile(File fileToZip, File zipFile) throws AutomationException {
        try {
            FileInputStream fis = new FileInputStream(fileToZip);

            try {
                FileOutputStream fos = new FileOutputStream(zipFile);

                try {
                    ZipOutputStream zipOut = new ZipOutputStream(fos);

                    try {
                        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                        zipOut.putNextEntry(zipEntry);
                        byte[] bytes = new byte[1024];

                        int length;
                        while((length = fis.read(bytes)) >= 0) {
                            zipOut.write(bytes, 0, length);
                        }
                    } catch (Throwable var11) {
                        try {
                            zipOut.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }

                        throw var11;
                    }

                    zipOut.close();
                } catch (Throwable var12) {
                    try {
                        fos.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }

                    throw var12;
                }

                fos.close();
            } catch (Throwable var13) {
                try {
                    fis.close();
                } catch (Throwable var8) {
                    var13.addSuppressed(var8);
                }

                throw var13;
            }

            fis.close();
        } catch (IOException var14) {
            throw new AutomationException(var14);
        }
    }

    public static void zipFiles(List<File> filesToZip, File zipFile) throws AutomationException {
        try {
            FileOutputStream fos = new FileOutputStream(zipFile);

            try {
                ZipOutputStream zipOut = new ZipOutputStream(fos);

                try {
                    logger.debug("Opened archived {}", zipFile);
                    Iterator var4 = filesToZip.iterator();

                    while(var4.hasNext()) {
                        File fileToZip = (File)var4.next();

                        try {
                            FileInputStream fis = new FileInputStream(fileToZip);

                            try {
                                logger.debug("Prepared file input stream for file {} to be added to archive", fileToZip);
                                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                                zipOut.putNextEntry(zipEntry);
                                byte[] bytes = new byte[1024];

                                while(true) {
                                    int length;
                                    if ((length = fis.read(bytes)) < 0) {
                                        logger.debug("Done archiving {} into archive", fileToZip);
                                        break;
                                    }

                                    zipOut.write(bytes, 0, length);
                                }
                            } catch (Throwable var13) {
                                try {
                                    fis.close();
                                } catch (Throwable var12) {
                                    var13.addSuppressed(var12);
                                }

                                throw var13;
                            }

                            fis.close();
                        } catch (IOException var14) {
                            throw new AutomationException(var14);
                        }
                    }
                } catch (Throwable var15) {
                    try {
                        zipOut.close();
                    } catch (Throwable var11) {
                        var15.addSuppressed(var11);
                    }

                    throw var15;
                }

                zipOut.close();
            } catch (Throwable var16) {
                try {
                    fos.close();
                } catch (Throwable var10) {
                    var16.addSuppressed(var10);
                }

                throw var16;
            }

            fos.close();
        } catch (IOException var17) {
            throw new AutomationException(var17);
        }
    }

    public static void zipFolder(File folderPath, File zipFileName) throws AutomationException {
        try {
            ZipFile zipFile = new ZipFile(zipFileName);

            try {
                ZipParameters parameters = new ZipParameters();
                parameters.setCompressionMethod(CompressionMethod.DEFLATE);
                parameters.setCompressionLevel(CompressionLevel.NORMAL);
                zipFile.addFolder(folderPath, parameters);
            } catch (Throwable var6) {
                try {
                    zipFile.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            zipFile.close();
        } catch (Exception var7) {
            throw new AutomationException("Failed to zip %s to %s.", var7, new Object[]{zipFileName.getAbsolutePath(), folderPath.getAbsolutePath()});
        }
    }

    public static void deleteFilesByWildcard(File folder, final String wildcard) {
        File[] fileList = folder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches(wildcard);
            }
        });
        File[] var3 = fileList;
        int var4 = fileList.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File file = var3[var5];
            file.delete();
        }

    }

    public static File getLastFileModified(File dir) {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".txt");
            }
        });
        long lastMod = -9223372036854775808L;
        File choice = null;
        File[] var5 = files;
        int var6 = files.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            File file = var5[var7];
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }

        return choice;
    }

    public static boolean isStringExists(File file, String searchString) throws AutomationException {
        String filePath = file.getAbsolutePath();

        try {
            List<String> list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            Iterator var4 = list.iterator();

            String line;
            do {
                if (!var4.hasNext()) {
                    logger.debug("The string {} is not found in the file {}.", searchString, filePath);
                    return false;
                }

                line = (String)var4.next();
            } while(!line.contains(searchString));

            logger.debug("The string {} is found in the file {}.", searchString, filePath);
            return true;
        } catch (Exception var6) {
            throw new AutomationException("Failed to read the file '%s'.", var6, new Object[]{filePath});
        }
    }

    public static void deleteDirectory(File folder) throws AutomationException {
        try {
            FileUtils.deleteDirectory(folder);
        } catch (IOException var2) {
            throw new AutomationException("Cannot delete the directory %s.", var2, new Object[]{folder.getAbsolutePath()});
        }
    }

    public static void unzip(String source, String destination) {
        try {
            ZipFile zipFile = new ZipFile(source);

            try {
                zipFile.extractAll(destination);
                logger.info("File {} unziped to {} successfully", source, destination);
            } catch (Throwable var6) {
                try {
                    zipFile.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            zipFile.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public static void cleanCreateFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            (new File(folderPath)).mkdir();
            logger.info("Directory not found and has been created");
        } else {
            try {
                FileUtils.cleanDirectory(folder);
                logger.info("Directory exists and has been cleaned successfully");
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

    }

    public static Properties loadProperties(File propFile) throws IOException {
        Properties defaultProps = new Properties();
        FileInputStream in = new FileInputStream(propFile);

        try {
            defaultProps.load(in);
        } catch (Throwable var6) {
            try {
                in.close();
            } catch (Throwable var5) {
                var6.addSuppressed(var5);
            }

            throw var6;
        }

        in.close();
        return defaultProps;
    }

    // public static File copyFileFromWindowsNetworkToHost(String hostTempFolder, String pathToNetworkFile, String targetFolder) throws AutomationException {
    //     String command = String.format("xcopy /v/y/h/r %s %s", pathToNetworkFile, targetFolder.replace("\\", "\\\\"));
    //     File targetFile = null;
    //     File batchFile = null;
    //
    //     try {
    //         batchFile = File.createTempFile("CopyFromNetwork", ".BAT", new File(hostTempFolder));
    //         writeToFile(batchFile, command);
    //         String commandOutput = ServicesUtil.getCommandOutput(batchFile.getAbsolutePath()).replaceAll("\\s+", "");
    //         File networkFile = new File(pathToNetworkFile);
    //         targetFile = new File(targetFolder, networkFile.getName());
    //         if (!targetFile.exists()) {
    //             throw new AutomationException("Failed to copy file %s from network to host. Output:[%n%s%n]%n", new Object[]{networkFile.getName(), commandOutput});
    //         }
    //
    //         logger.info("File {} is copied from network to host successfully.", networkFile.getName());
    //     } catch (IOException var11) {
    //         throw new AutomationException("Exception occurs:", var11);
    //     } finally {
    //         if (batchFile != null && batchFile.exists()) {
    //             deleteFile(batchFile);
    //         }
    //
    //     }
    //
    //     return targetFile;
    // }

    // public static String getFileVersion(String hostTempFolder, File targetFile) throws AutomationException {
    //     String command = String.format("C:\r\nCD C:\\\\Windows\\\\System32\\\\Wbem\r\nwmic datafile where name=\"%s\" get version", targetFile.getAbsolutePath().replace("\\", "\\\\"));
    //     String fileVersion = null;
    //     File batchFile = null;
    //
    //     try {
    //         batchFile = File.createTempFile("GetFileVersion", ".BAT", new File(hostTempFolder));
    //         writeToFile(batchFile, command);
    //         String output = ServicesUtil.getCommandOutput(batchFile.getAbsolutePath());
    //         String[] outputArray = output.split("\n");
    //         if (outputArray == null || outputArray.length <= 1) {
    //             throw new AutomationException("Failed to get file version for file [%s]%n", new Object[]{targetFile.getAbsolutePath()});
    //         }
    //
    //         fileVersion = outputArray[outputArray.length - 1];
    //     } catch (IOException var10) {
    //         throw new AutomationException("Exception occurs:", var10);
    //     } finally {
    //         if (batchFile != null && batchFile.exists()) {
    //             deleteFile(batchFile);
    //         }
    //
    //     }
    //
    //     return fileVersion;
    // }

    // public static void replaceAll(File sourceFile, String searchKey, String replaceValue) throws IOException {
    //     String sourceFileName = sourceFile.getName();
    //     String fileNamePrefix = sourceFileName.substring(0, sourceFileName.lastIndexOf("."));
    //     String fileExtension = sourceFileName.substring(sourceFileName.lastIndexOf("."));
    //     Path tempFilePath = Files.createTempFile(fileNamePrefix, fileExtension);
    //     File tempFile = tempFilePath.toFile();
    //
    //     try {
    //         Stream input = Files.lines(Paths.get(sourceFile.getAbsolutePath()));
    //
    //         try {
    //             PrintWriter output = new PrintWriter(tempFile, "UTF-8");
    //
    //             try {
    //                 Stream var10000 = input.map((s) -> {
    //                     return s.replaceAll(searchKey, replaceValue);
    //                 });
    //                 Objects.requireNonNull(output);
    //                 var10000.forEachOrdered(output::println);
    //             } catch (Throwable var20) {
    //                 try {
    //                     output.close();
    //                 } catch (Throwable var19) {
    //                     var20.addSuppressed(var19);
    //                 }
    //
    //                 throw var20;
    //             }
    //
    //             output.close();
    //         } catch (Throwable var21) {
    //             if (input != null) {
    //                 try {
    //                     input.close();
    //                 } catch (Throwable var18) {
    //                     var21.addSuppressed(var18);
    //                 }
    //             }
    //
    //             throw var21;
    //         }
    //
    //         if (input != null) {
    //             input.close();
    //         }
    //     } finally {
    //         if (tempFile.exists()) {
    //             Files.delete(sourceFile.toPath());
    //             Files.move(tempFilePath, sourceFile.toPath());
    //         }
    //
    //     }
    //
    // }

    // public static File replaceAll(File sourceFile, Map<String, String> stringReplaceMap, boolean isCreateTempFile) throws IOException {
    //     String sourceFileName = sourceFile.getName();
    //     String fileNamePrefix = sourceFileName.substring(0, sourceFileName.lastIndexOf("."));
    //     String fileExtension = sourceFileName.substring(sourceFileName.lastIndexOf("."));
    //     Path targetFilePath = Files.createTempFile(fileNamePrefix, fileExtension);
    //     Stream input = Files.lines(Paths.get(sourceFile.getAbsolutePath()));
    //
    //     try {
    //         PrintWriter output = new PrintWriter(targetFilePath.toFile(), "UTF-8");
    //
    //         try {
    //             Objects.requireNonNull(output);
    //             input.forEachOrdered(output::println);
    //         } catch (Throwable var13) {
    //             try {
    //                 output.close();
    //             } catch (Throwable var12) {
    //                 var13.addSuppressed(var12);
    //             }
    //
    //             throw var13;
    //         }
    //
    //         output.close();
    //     } catch (Throwable var14) {
    //         if (input != null) {
    //             try {
    //                 input.close();
    //             } catch (Throwable var11) {
    //                 var14.addSuppressed(var11);
    //             }
    //         }
    //
    //         throw var14;
    //     }
    //
    //     if (input != null) {
    //         input.close();
    //     }
    //
    //     Iterator var15 = stringReplaceMap.keySet().iterator();
    //
    //     while(var15.hasNext()) {
    //         String searchKey = (String)var15.next();
    //         replaceAll(targetFilePath.toFile(), searchKey, (String)stringReplaceMap.get(searchKey));
    //     }
    //
    //     if (isCreateTempFile) {
    //         return targetFilePath.toFile();
    //     } else {
    //         Files.delete(sourceFile.toPath());
    //         Files.move(targetFilePath, sourceFile.toPath());
    //         return sourceFile;
    //     }
    // }

    // public static File replaceAll(File sourceFile, Map<String, String> stringReplaceMap) throws IOException {
    //     return replaceAll(sourceFile, stringReplaceMap, true);
    // }

    public static String getMd5Hash(File sourceFile) throws FileNotFoundException, IOException {
        String md5Digest = null;
        FileInputStream is = new FileInputStream(sourceFile);

        try {
            md5Digest = DigestUtils.md5Hex(is);
        } catch (Throwable var6) {
            try {
                is.close();
            } catch (Throwable var5) {
                var6.addSuppressed(var5);
            }

            throw var6;
        }

        is.close();
        return md5Digest;
    }

    public static File downloadFile(String fileUrl) throws IOException {
        String providerFilename = fileUrl.substring(fileUrl.lastIndexOf("/") + 1, fileUrl.lastIndexOf(".")).replaceAll("%20", " ");
        String extension = fileUrl.substring(fileUrl.lastIndexOf("."));
        File tempFile = File.createTempFile(providerFilename, extension);
        URL targetUrl = new URL(fileUrl);
        FileUtils.copyURLToFile(targetUrl, tempFile);
        return tempFile;
    }

    public static String fileContentsToString(String sourceTextFilePath) throws AutomationException {
        StringBuffer fileContents = new StringBuffer();
        File sourceTextFile = new File(sourceTextFilePath);
        if (sourceTextFile.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(sourceTextFile));

                try {
                    for(String line = br.readLine(); line != null; line = br.readLine()) {
                        fileContents.append(line);
                    }
                } catch (Throwable var7) {
                    try {
                        br.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }

                    throw var7;
                }

                br.close();
            } catch (IOException var8) {
                throw new AutomationException("Failed to read file %s.", var8, new Object[]{sourceTextFilePath});
            }

            return fileContents.toString();
        } else {
            logger.error("File {} does not exists.", sourceTextFilePath);
            return null;
        }
    }

    public static String fileContentsToStringWithCharsetName(String sourceTextFilePath, String charsetName) throws AutomationException {
        StringBuilder contentBuilder = new StringBuilder();
        File sourceTextFile = new File(sourceTextFilePath);
        if (sourceTextFile.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourceTextFile), charsetName));

                String sCurrentLine;
                try {
                    while((sCurrentLine = br.readLine()) != null) {
                        contentBuilder.append(sCurrentLine).append("\n");
                    }
                } catch (Throwable var8) {
                    try {
                        br.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }

                    throw var8;
                }

                br.close();
            } catch (IOException var9) {
                throw new AutomationException("Failed to read file %s.", var9, new Object[]{sourceTextFilePath});
            }

            return contentBuilder.toString();
        } else {
            logger.error("File {} does not exists.", sourceTextFilePath);
            return null;
        }
    }

    public static Properties loadPropertiesFolder(String folderPath) throws IOException {
        Properties defaultProps = new Properties();
        File propFolderPath = new File(folderPath);
        File[] files = propFolderPath.listFiles();

        for(int i = 0; i < files.length; ++i) {
            try {
                FileInputStream in = new FileInputStream(files[i]);

                try {
                    defaultProps.load(in);
                } catch (Throwable var9) {
                    try {
                        in.close();
                    } catch (Throwable var8) {
                        var9.addSuppressed(var8);
                    }

                    throw var9;
                }

                in.close();
            } catch (IOException var10) {
                logger.error("Exception occurs when closing stream: {}", var10.getMessage());
            }
        }

        return defaultProps;
    }

    private static void silentClose(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException var2) {
                System.err.format("Exception occurs when closing stream: %s%n", var2.getMessage());
            }
        }

    }

    public static List<String> readLines(File targetFile) throws FileNotFoundException, IOException {
        return readLines(targetFile, "UTF-16");
    }

    public static List<String> readLines(File targetFile, String encoding) throws FileNotFoundException, IOException {
        List<String> textLines = null;
        String defaultEncoding;
        if (encoding == null) {
            defaultEncoding = "UTF-8";
        } else {
            defaultEncoding = encoding;
        }

        FileInputStream inputStream = new FileInputStream(targetFile);

        try {
            BOMInputStream bomInputStream = new BOMInputStream(inputStream);

            try {
                ByteOrderMark bom = bomInputStream.getBOM();
                String charsetName = bom == null ? defaultEncoding : bom.getCharsetName();
                BufferedReader br = new BufferedReader(new InputStreamReader(bomInputStream, charsetName));

                try {
                    textLines = new ArrayList();
                    String currentLine = null;

                    while((currentLine = br.readLine()) != null) {
                        textLines.add(currentLine);
                    }
                } catch (Throwable var14) {
                    try {
                        br.close();
                    } catch (Throwable var13) {
                        var14.addSuppressed(var13);
                    }

                    throw var14;
                }

                br.close();
            } catch (Throwable var15) {
                try {
                    bomInputStream.close();
                } catch (Throwable var12) {
                    var15.addSuppressed(var12);
                }

                throw var15;
            }

            bomInputStream.close();
        } catch (Throwable var16) {
            try {
                inputStream.close();
            } catch (Throwable var11) {
                var16.addSuppressed(var11);
            }

            throw var16;
        }

        inputStream.close();
        return textLines;
    }
}
