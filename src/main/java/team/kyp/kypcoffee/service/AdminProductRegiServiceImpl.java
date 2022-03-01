package team.kyp.kypcoffee.service;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.AdminProductRegiCommand;
import team.kyp.kypcoffee.mapper.AdminProductMapper;

import java.io.File;
import java.util.UUID;

@Service
public class AdminProductRegiServiceImpl implements AdminProductRegiService{

    private AdminProductMapper mapper;

    public AdminProductRegiServiceImpl (AdminProductMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void adminProductRegi(AdminProductRegiCommand adminProductRegiCommand) {
        mapper.insertAdminProduct(adminProductRegiCommand);
    }

    //파일 업로드
    @Override
    public void uploadProductImg(AdminProductRegiCommand adminProductRegiCommand) {

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + adminProductRegiCommand.getProductImg().getOriginalFilename();
        adminProductRegiCommand.setImgName(fileName);

        uuid = UUID.randomUUID();
        String contentFileName = uuid + "_" + adminProductRegiCommand.getProductContentImg().getOriginalFilename();
        adminProductRegiCommand.setContentImgName(contentFileName);

        try{
            File folder = new File("C:\\productImg");
            if (!folder.exists()) folder.mkdirs();

            File destination = new File("C:\\productImg" + File.separator + fileName);
            File destination2 = new File("C:\\productImg" + File.separator + contentFileName);
            adminProductRegiCommand.getProductImg().transferTo(destination);
            adminProductRegiCommand.getProductContentImg().transferTo(destination2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
