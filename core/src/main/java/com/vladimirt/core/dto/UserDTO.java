package com.vladimirt.core.dto;

import com.vladimirt.core.model.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String email;
    private Set<RoleDTO> roles;

}
