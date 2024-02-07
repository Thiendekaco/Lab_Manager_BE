package com.labmanager.project.rest.laboratory;


import com.labmanager.project.dto.LabMemberDTO;
import com.labmanager.project.dto.LaboratoryDTO;
import com.labmanager.project.dto.LaboratoryDetailDTO;
import com.labmanager.project.entity.laboratory.LaboratoryDetail;
import com.labmanager.project.entity.laboratory.LaboratoryGeneral;
import com.labmanager.project.entity.member.Member;
import com.labmanager.project.entity.member.RoleMember;
import com.labmanager.project.service.laboratory.LaboratoryDetailService;
import com.labmanager.project.service.laboratory.LaboratoryGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryRestController {

    private LaboratoryGeneralService laboratoryGeneralService;
    private LaboratoryDetailService laboratoryDetailService;

    @Autowired
    public  LaboratoryRestController(LaboratoryDetailService laboratoryDetailService, LaboratoryGeneralService laboratoryGeneralService){
        this.laboratoryDetailService = laboratoryDetailService;
        this.laboratoryGeneralService = laboratoryGeneralService;
    }


    @GetMapping("/laboratories/{laboratoryName}")
    public List<LaboratoryDTO> getLaboratoryByName (@PathVariable String laboratoryName){
        return laboratoryGeneralService.findByName(laboratoryName).stream().map(this::convertEntityToLabDTO).toList();
    }


    @GetMapping("/laboratories")
    public List<LaboratoryDTO> getAllLaboratory (){
        return laboratoryGeneralService.findAll().stream().map(this::convertEntityToLabDTO).toList();
    }

    @PutMapping("/laboratories")
    public LaboratoryDTO createNewLaboratory (@RequestBody ParamRequestCreateLab param) {
        if(param.getLaboratoryGeneral() == null){
            return null;
        }
        laboratoryGeneralService.createNewLaboratory(param.getAdmin(), param.getLaboratoryGeneral());

        return convertEntityToLabDTO(laboratoryGeneralService.findByName(param.getLaboratoryGeneral().getNameLab()).get(0));
    }

    @PostMapping("/laboratories/{nameLab}")
    public LaboratoryDTO updateGeneralLaboratory (@RequestBody LaboratoryGeneral lab, @PathVariable String nameLab){
        return convertEntityToLabDTO(laboratoryGeneralService.updateLaboratory(lab, nameLab));
    }

    @DeleteMapping("/laboratories/{nameLab}")
    public void deleteGeneralLaboratory (@PathVariable String nameLab){
        laboratoryGeneralService.deleteLaboratory(nameLab);
    }

    private LaboratoryDTO convertEntityToLabDTO(LaboratoryGeneral laboratoryGeneral){
        LaboratoryDetail laboratoryDetail = laboratoryGeneral.getLaboratoryDetail();
        List<RoleMember> memberList = laboratoryGeneral.getLaboratoryDetail().getMembers();
        List<LabMemberDTO> labMemberDTOS = new ArrayList<LabMemberDTO>();
        memberList.stream().forEach(roleMember -> {
            Member member = roleMember.getMember();
            labMemberDTOS.add( new LabMemberDTO(
                    member.getName(),
                    member.getUser().getEmail(),
                    member.getUniversity(),
                    member.getAge(),
                    "http://localhost:8080/api/image/" + member.getLogo().getId()
                    , roleMember.getTimeJoined(),
                    roleMember.getStatusJoined(),
                    roleMember.getRole()));
        });
        LaboratoryDetailDTO laboratoryDetailDTO = new LaboratoryDetailDTO(labMemberDTOS, laboratoryDetail.getRoles(), laboratoryDetail.getNumberOfMember(), laboratoryDetail.getDescription());

        return new LaboratoryDTO(
                laboratoryGeneral.getNameLab(),
                laboratoryGeneral.getNameSchool(),
                laboratoryGeneral.getField(),
                laboratoryDetailDTO,
                "http://localhost:8080/api/image/" + laboratoryGeneral.getLogo().getId(),
                laboratoryGeneral.getRanking(),
                laboratoryGeneral.getLocation(),
                laboratoryGeneral.getCountry()
                );
    }

}

 class ParamRequestCreateLab {
    private String admin;

    private LaboratoryGeneral laboratoryGeneral;

    public ParamRequestCreateLab(String admin, LaboratoryGeneral laboratoryGeneral) {
        this.admin = admin;
        this.laboratoryGeneral = laboratoryGeneral;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public LaboratoryGeneral getLaboratoryGeneral() {
        return laboratoryGeneral;
    }

    public void setLaboratoryGeneral(LaboratoryGeneral laboratoryGeneral) {
        this.laboratoryGeneral = laboratoryGeneral;
    }
}