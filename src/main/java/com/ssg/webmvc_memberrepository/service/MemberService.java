package com.ssg.webmvc_memberrepository.service;

import com.ssg.webmvc_memberrepository.dao.MemberDAO;
import com.ssg.webmvc_memberrepository.domain.MemberVO;
import com.ssg.webmvc_memberrepository.dto.MemberDTO;
import com.ssg.webmvc_memberrepository.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public List<MemberDTO> listAllMembers() throws Exception {
        List<MemberVO> voList = dao.listMembers();
        return voList.stream().map(vo->modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
    }

    public void insertMember(MemberDTO dto) throws Exception {
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        dao.insert(vo);
    }

    public void modifyMember(MemberDTO dto) throws Exception{
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        dao.modify(vo);
    }

    public MemberDTO getMember(String mid) throws Exception{
        MemberVO vo = dao.selectOne(mid);
        return modelMapper.map(vo, MemberDTO.class);
    }
    public void deleteMember(String mid) throws Exception{
        dao.deleteOne(mid);
    }
    public MemberDTO login(String mid, String mpw) throws Exception{
        MemberVO vo = dao.login(mid,mpw);
        return modelMapper.map(vo, MemberDTO.class);
    }
}
