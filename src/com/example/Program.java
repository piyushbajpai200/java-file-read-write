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
        writeString(writePathString, "Hi there!");

        Path writePathBinary = Path.of("src/binary.txt");
        writeBinary(writePathBinary, "Hi there!".getBytes(StandardCharsets.UTF_8));
    }

    static void readCharacter(Path filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
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
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(filePath.toFile()))) {
            int ch;

            while ((ch = stream.read()) != -1) {
                System.out.println((char) ch);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static void writeCharacter(Path filePath, char[] content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
            writer.write(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeBinary(Path filePath, byte[] content) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath.toFile()))) {
            outputStream.write(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
