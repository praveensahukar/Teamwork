
package com.Paladion.teamwork.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author pal
 */

@Entity
@Table(name="")
@SecondaryTable(name="")
public class ViewAllRequestSchedule implements Serializable {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
int Schedule_id;
@Column(name = "prefstartdate")
@DateTimeFormat (pattern="MM/dd/yyyy")
@Temporal(javax.persistence.TemporalType.DATE)
Date prefstartdate;

String asstype;

@Column(name = "effort")
String effort;

@Column(name = "hosting")
String hosting;

@Column(name = "region")
String region;

@Column(name = "projectname")
String projectname;

}
