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
import triple.backend.controller.UserController;
import triple.backend.dto.EventResponse;
import triple.backend.dto.PointResponse;
import triple.backend.enums.StatusCode;
import triple.backend.service.ResponseService;
import triple.backend.service.UserService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(RestDocConfiguration.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ResponseService responseService;

    @MockBean
    private UserService userService;

    final String USER_ID = "3ede0ef2-92b7-4817-a5f3-0c575361f745";

    @Test
    @DisplayName("get user point test")
    public void get_user_point_test() throws Exception{
        //given
        PointResponse pointResponse = PointResponse.builder()
                .userId(USER_ID)
                .point(3)
                .build();
        EventResponse<PointResponse> response = new EventResponse<>();
        response.setStatus(StatusCode.SUCCESS.getStatus());
        response.setCode(StatusCode.SUCCESS.getCode());
        response.setMessage(StatusCode.SUCCESS.getMessage());
        response.setData(pointResponse);

        given(responseService.getEventResult(userService.getUserPoint(anyString())))
                .willReturn(response);

        //when
        ResultActions result = this.mockMvc.perform(get("/users/point")
                .param("userId", USER_ID)
                .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(StatusCode.SUCCESS.getStatus()))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.message").value(StatusCode.SUCCESS.getMessage()))
                .andExpect(jsonPath("$.data.userId").value(USER_ID))
                .andExpect(jsonPath("$.data.point").value(3))
                .andDo(document("get-user-point",
                        requestHeaders(
                                headerWithName(HttpHeaders.ACCEPT).description(MediaType.APPLICATION_JSON_VALUE)
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
