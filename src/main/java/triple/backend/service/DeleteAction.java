package triple.backend.service;

import lombok.RequiredArgsConstructor;
import triple.backend.dto.EventRequest;

@RequiredArgsConstructor
public class DeleteAction extends Action {
    private final ReviewService reviewServiceImpl;
    @Override
    public int calculatePoints(EventRequest eventRequest) {
        //1.1.리뷰를 작성했다가 삭제하면 해당 리뷰로 부여한 내용 점수와 보너스 점수는 회수합니다.
        return 0;
    }

    @Override
    public void Do(EventRequest eventRequest) {
        reviewServiceImpl.deleteReview(eventRequest);
    }
}
