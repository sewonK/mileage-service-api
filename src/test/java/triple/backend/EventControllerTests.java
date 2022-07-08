package triple.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import triple.backend.controller.EventController;
import triple.backend.dto.EventRequest;
import triple.backend.dto.EventResponse;
import triple.backend.dto.PointResponse;
import triple.backend.enums.ActionType;
import triple.backend.enums.StatusCode;
import triple.backend.service.PointService;
import triple.backend.service.ResponseService;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EventController.class)
@Import(RestDocConfiguration.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class EventControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ResponseService responseService;

    @MockBean
    private PointService pointService;

    @Test
    @DisplayName("point add test")
    public void point_add_test() throws Exception{
        //given
        PointResponse pointResponse = PointResponse.builder()
                .userId("3ede0ef2-92b7-4817-a5f3-0c575361f745")
                .point(3)
                .build();
        EventResponse<PointResponse> response = new EventResponse<>();
        response.setStatus(StatusCode.SUCCESS.getStatus());
        response.setCode(StatusCode.SUCCESS.getCode());
        response.setMessage(StatusCode.SUCCESS.getMessage());
        response.setData(pointResponse);

        given(responseService.getEventResult(pointService.handleEvent(any(EventRequest.class))))
                .willReturn(response);

        //when
        EventRequest request = EventRequest.builder()
                .type("REVIEW")
                .action(ActionType.ADD)
                .reviewId("240a0658-dc5f-4878-9381-ebb7b2667772")
                .content("좋아요!")
                .attachedPhotoIds(Stream.of("e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-851d-4a50-bb07-9cc15cbdc332").collect(Collectors.toList()))
                .userId("3ede0ef2-92b7-4817-a5f3-0c575361f745")
                .placeId("2e4baf1c-5acb-4efb-a1af-eddada31b00f")
                .build();

        ResultActions result = this.mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        );

        //then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(StatusCode.SUCCESS.getStatus()))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.message").value(StatusCode.SUCCESS.getMessage()))
                .andExpect(jsonPath("$.data.userId").value("3ede0ef2-92b7-4817-a5f3-0c575361f745"))
                .andExpect(jsonPath("$.data.point").value(3))
                .andDo(document("point-add",
                        requestHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description(MediaType.APPLICATION_JSON_VALUE),
                                headerWithName(HttpHeaders.ACCEPT).description(MediaType.APPLICATION_JSON_VALUE)
                        ),
                        requestFields(
                                fieldWithPath("type").type(JsonFieldType.STRING).description("타입"),
                                fieldWithPath("action").type(JsonFieldType.STRING).description("행동"),
                                fieldWithPath("reviewId").type(JsonFieldType.STRING).description("리뷰 id"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("리뷰 내용"),
                                fieldWithPath("attachedPhotoIds").type(JsonFieldType.ARRAY).description("이미지 id 배열"),
                                fieldWithPath("userId").type(JsonFieldType.STRING).description("사용자 id"),
                                fieldWithPath("placeId").type(JsonFieldType.STRING).description("장소 id")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.CONTENT_TYPE).description(MediaType.APPLICATION_JSON_VALUE)
                        ),
                        responseFields(
                                fieldWithPath("status").type(JsonFieldType.NUMBER).description("상태코드"),
                                fieldWithPath("code").type(JsonFieldType.STRING).description("결과코드"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("결과값"),
                                fieldWithPath("data.userId").type(JsonFieldType.STRING).description("사용자 id"),
                                fieldWithPath("data.point").type(JsonFieldType.NUMBER).description("누적 포인트 값")
                        ))
                );
    }
}
