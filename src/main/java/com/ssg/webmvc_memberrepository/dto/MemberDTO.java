package com.ssg.webmvc_memberrepository.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String memail;
    private LocalDate joindate;
}
