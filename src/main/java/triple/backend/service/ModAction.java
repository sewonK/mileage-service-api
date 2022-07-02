package triple.backend.service;

import lombok.RequiredArgsConstructor;
import triple.backend.dto.EventRequest;

@RequiredArgsConstructor
public class ModAction extends Action {
    private final ReviewService reviewServiceImpl;

    @Override
    public int calculatePoints(EventRequest eventRequest) {
        //1. 점수 계산
        //1.1. 글만 작성한 리뷰에 사진을 추가하면 1점을 부여합니다.
        //1.2. 글과 사진이 있는 리뷰에서 사진을 모두 삭제하면 1점을 회수합니다.
        return 0;
    }

    @Override
    public void Do(EventRequest eventRequest) {
        reviewServiceImpl.saveReview(eventRequest);
    }
}
