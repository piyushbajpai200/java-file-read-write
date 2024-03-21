package com.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Program {
    public static void main(String[] args) {
        //  Read operations
        Path filePath = Path.of("src/hello.txt");

        readCharacter(filePath);
        System.out.println("-----------------------");
        readString(filePath);
        System.out.println("-----------------------");
        readBinary(filePath);

        //  Write operations
        Path writePathCharacter = Path.of("src/char.txt");
        writeCharacter(writePathCharacter, "Hi there!".toCharArray());

        Path writePathString = Path.of("src/string.txt");
        writeString(writePathString, "Good evening!");

        Path writePathBinary = Path.of("src/binary.txt");
        writeBinary(writePathBinary, "Hi there!".getBytes(StandardCharsets.UTF_8));

        Path imageSourcePath = Path.of("src/image.gif");
        Path imageTargetPath = Path.of("src/copy.gif");
        copyBinaryFile(imageSourcePath, imageTargetPath);
    }

    static void readCharacter(Path filePath) {
        try (Reader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void readString(Path filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;

            //  readLine() is available only on BufferedReader
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void readBinary(Path filePath) {
        try (InputStream stream = new BufferedInputStream(new FileInputStream(filePath.toFile()))) {
            int ch;

            while ((ch = stream.read()) != -1) {
                System.out.print(ch);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static void writeCharacter(Path filePath, char[] content) {
        try (Writer writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
//          shorter
            writer.write(content);

//            verbose
//            for (char c: content) {
//                writer.write(c);
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeString(Path filePath, String content) {
        try (Writer writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
            writer.write(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeBinary(Path filePath, byte[] content) {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath.toFile()))) {
            outputStream.write(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void copyBinaryFile(Path sourceFilePath, Path targetFilePath) {
        try (
                InputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFilePath.toFile()));
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFilePath.toFile()))
        ) {
            byte[] data = inputStream.readAllBytes();
            outputStream.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
