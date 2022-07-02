package triple.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triple.backend.dto.EventRequest;

@Service
@RequiredArgsConstructor
public class AddAction extends Action {
    private final ReviewService reviewServiceImpl;

    @Override
    public int calculatePoints(EventRequest eventRequest) {
        //1.1. 텍스트 1자 이상인지 - 마다마다 갱신된다면 포인트 이력 쌓기
        //1.2. 사진 1장 이상 있는지
        //1.3. 현재 장소의 첫 리뷰인지
        return 0;
    }

    @Override
    public void Do(EventRequest eventRequest) {
        reviewServiceImpl.saveReview(eventRequest);
    }
}
