package team.kyp.kypcoffee.service.admin;

import org.springframework.stereotype.Service;
import team.kyp.kypcoffee.domain.Paging;
import team.kyp.kypcoffee.domain.admin.Review;
import team.kyp.kypcoffee.mapper.admin.ReviewManageMapper;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewManageMapper mapper;
    public ReviewServiceImpl(ReviewManageMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<Review> selectReviewList(Paging paging) {
        return mapper.reviewList(paging);
    }

    @Override
    public int selectAllCnt() {
        return mapper.selectAllCnt();
    }

    @Override
    public String totalCntJudge(int totalCnt) {
        String judge = "";
        if(totalCnt > 100) judge = "101";
        if(totalCnt == 100) judge = "100";
        if(totalCnt < 100) judge = "99";

        return judge;
    }

    @Override
    public List<Review> selectReviewByNum(int reviewNum) {
        return mapper.selectReviewByNum(reviewNum);
    }

    @Override
    public void deleteByNum(int reviewNum) {
        mapper.deleteByNum(reviewNum);
    }
}
