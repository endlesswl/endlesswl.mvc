package com.palm.lingcai.util.upload;

/**
 * Created by nzhmac on 16/7/7.
 */

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileuploadUtil {
    private static String temp = "/uploadfile";
    public static String realPath = "";
    private static long fileMaxSize = 5120000L;
    private static String errorMsg = "{\"resultCode\":\"50001\",\"retultMsg\":\"不是multipart/form-data类型\"}";
    private static String otherMsg = "{\"resultCode\":\"50002\",\"retultMsg\":\"请选择文件\"}";
    private static String noAuth = "{\"resultCode\":\"50003\",\"retultMsg\":\"该用户没有改权限\"}";
    private static String sizeMsg = "{\"resultCode\":\"50004\",\"retultMsg\":\"文件大小超过1M，请重新选择！\"}";
    private static String unknowMsg = "{\"resultCode\":\"50009\",\"retultMsg\":\"文件上传失败，请重新上传或联系管理员！\"}";

    public FileuploadUtil() {
    }

    public static String uploadFile(HttpServletRequest request) {
        try {
            realPath = WebUtils.getRealPath(request.getSession().getServletContext(), "/");//项目部署路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //realPath = "/data/web_app/futian/";
        StringBuilder uploadTemp = new StringBuilder();
        uploadTemp.append(realPath).append(temp);
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        InputStream inputStream = null;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = dateFormat.format(date);
        StringBuilder uploadDir = new StringBuilder();
        uploadDir.append(uploadTemp.toString()).append("/").append(year).append("/").append(month).append("/");

        String var26;
        try {
            if (!multipartContent) {
                var26 = errorMsg;
                return var26;
            }

            DiskFileItemFactory e = new DiskFileItemFactory();
            e.setSizeThreshold(4096);
            ServletFileUpload upload = new ServletFileUpload(e);
            upload.setSizeMax(fileMaxSize);
            List items = upload.parseRequest(request);
            Iterator i = items.iterator();
            ArrayList fileList = new ArrayList();

            while (i.hasNext()) {
                FileItem fileItem = (FileItem) i.next();
                String fileName = fileItem.getName();
                if (fileName != null && !fileName.equals("")) {
                    String subStr = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                    int random = (new Random()).nextInt(10000);
                    inputStream = fileItem.getInputStream();
                    uploadDir.append(format).append("_").append(random).append(subStr);
                    File file = new File(uploadDir.toString());
                    if (file.getParentFile() != null && !file.getParentFile().exists()) {
                        file.getParentFile().mkdir();
                    }

                    FileResult fileResult = new FileResult();
                    fileResult.setFileName(file.getName());
                    String filePath = file.getAbsolutePath();
                    fileResult.setFilePath(filePath);
                    FileUtils.copyInputStreamToFile(inputStream, file);
                    fileList.add(fileResult);
                }
            }

            if (fileList != null && !fileList.isEmpty()) {
                var26 = returnOKMsg(fileList);
                return var26;
            }

            var26 = otherMsg;
        } catch (Exception var29) {
            System.out.println(var29);
            if (var29 instanceof SizeLimitExceededException) {
                var26 = sizeMsg;
                return var26;
            }

            var26 = unknowMsg;
            return var26;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return var26;
    }

    public static String uploadFile(HttpServletRequest request, long size) {
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            realPath = "C:\\";
            realPath = realPath;
        }

        StringBuilder uploadTemp = new StringBuilder();
        uploadTemp.append(realPath).append(temp);
        boolean multipartContent = ServletFileUpload.isMultipartContent(request);
        InputStream inputStream = null;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        int year = calendar.get(1);
        int month = calendar.get(2) + 1;
        int day = calendar.get(5);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = dateFormat.format(date);
        StringBuilder uploadDir = new StringBuilder();
        uploadDir.append(uploadTemp.toString()).append("/").append(year).append("/").append(month).append("/");

        String var28;
        try {
            try {
                if (!multipartContent) {
                    var28 = errorMsg;
                    return var28;
                }

                DiskFileItemFactory e = new DiskFileItemFactory();
                e.setSizeThreshold(4096);
                ServletFileUpload upload = new ServletFileUpload(e);
                upload.setSizeMax(size);
                List items = upload.parseRequest(request);
                Iterator i = items.iterator();
                ArrayList fileList = new ArrayList();

                while (i.hasNext()) {
                    FileItem fileItem = (FileItem) i.next();
                    String fileName = fileItem.getName();
                    if (fileName != null && !fileName.equals("")) {
                        String subStr = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                        int random = (new Random()).nextInt(10000);
                        inputStream = fileItem.getInputStream();
                        uploadDir.append(format).append("_").append(random).append(subStr);
                        File file = new File(uploadDir.toString());
                        if (file.getParentFile() != null && !file.getParentFile().exists()) {
                            file.getParentFile().mkdir();
                        }

                        FileResult fileResult = new FileResult();
                        fileResult.setFileName(file.getName());
                        String filePath = file.getAbsolutePath();
                        fileResult.setFilePath(filePath);
                        FileUtils.copyInputStreamToFile(inputStream, file);
                        fileResult.setFileSize(Long.toString(fileItem.getSize()));
                        fileList.add(fileResult);
                    }
                }

                if (fileList != null && !fileList.isEmpty()) {
                    var28 = returnOKMsg(fileList);
                    return var28;
                }

                var28 = otherMsg;
                return var28;
            } catch (Exception var31) {
                System.out.println(var31);
                if (!(var31 instanceof SizeLimitExceededException)) {
                    var28 = unknowMsg;
                    return var28;
                }
            }

            var28 = sizeMsg;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return var28;
    }

    public static String returnOKMsg(List<FileResult> fileList) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"resultCode\":\"0\",\"retultMsg\":").append(JSON.toJSON(fileList)).append("}");
        return sb.toString();
    }

    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        File file = new File("/tmp/test.xls");

        try {
            byte[] e = FileUtils.readFileToByteArray(file);
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"tttt\"");
            response.addHeader("Content-Length", "" + e.length);
            response.setContentType("application/octet-stream;charset=UTF-8");
            BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(e);
            outputStream.flush();
            outputStream.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}
