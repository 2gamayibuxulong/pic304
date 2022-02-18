package com.example.pic.util;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class AssertUtil {
    public static void responseFile(File file, HttpServletResponse response) {
        try (FileImageInputStream input = new FileImageInputStream(file);
             ServletOutputStream output = response.getOutputStream()) {
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
                output.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
