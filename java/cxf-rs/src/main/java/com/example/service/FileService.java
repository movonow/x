package com.example.service;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Service
@Path("/file")
public class FileService {
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@Multipart("file") Attachment attachment) {
        try {
            File uploadDir = new File("uploads");

            if (!uploadDir.exists()) uploadDir.mkdirs();

            File uploadedFile = new File(uploadDir, attachment.getDataHandler().getName());
            try (FileOutputStream out = new FileOutputStream(uploadedFile)) {
                attachment.getDataHandler().writeTo(out);
            }

            return Response.ok("File uploaded successfully.").build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("File upload failed: " + e.getMessage()).build();
        }
    }

    @POST
    @Path("/upload2")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile2(Attachment file) {
        try {
            // 获取文件输入流和文件名
            InputStream inputStream = file.getDataHandler().getInputStream();
            String fileName = file.getContentDisposition().getParameter("filename");
            fileName = file.getContentDisposition().getFilename();

            // 设置文件保存路径
            File targetFile = new File("uploads/" + fileName);
            FileOutputStream outputStream = new FileOutputStream(targetFile);

            // 将文件流写入目标文件
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();

            return Response.status(Response.Status.OK).entity("File uploaded successfully!").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("File upload failed!").build();
        }
    }
}
