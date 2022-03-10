package team.kyp.kypcoffee.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.kyp.kypcoffee.domain.AdminProductRegiCommand;

import java.io.File;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Override
    public String uploadImg(MultipartFile multipartFile) {
        String fileName = null;

        UUID uuid = UUID.randomUUID();

        if(!multipartFile.isEmpty()){
            fileName = uuid + "_" + multipartFile.getOriginalFilename();
        }

        try{
            File folder = new File("C:\\productImg");
            if (!folder.exists()) folder.mkdirs();

            File destination = new File("C:\\productImg" + File.separator + fileName);
            multipartFile.transferTo(destination);

        }catch (Exception e){
            e.printStackTrace();
        }

        return fileName;
    }
}
