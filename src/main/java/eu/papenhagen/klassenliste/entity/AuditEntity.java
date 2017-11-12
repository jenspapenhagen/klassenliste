/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.klassenliste.entity;

import java.io.Serializable;
import lombok.*;

/**
 *
 * @author jay
 */
@AllArgsConstructor
public class AuditEntity  implements Serializable {

    @Getter
    @Setter
    private String createdBy;
    
    @Getter
    @Setter
    private String LastModifiedBy;

  
}
