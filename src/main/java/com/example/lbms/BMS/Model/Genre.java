package com.example.lbms.BMS.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



public enum Genre {
    AUTOBIOGRAPHY,
    BIOGRAPHY,
    COMEDY,
    ROMANCE,
    SCIENCE_FICTION,
    HISTORY,
    TECHNOLOGY,
    THRILLER,
    CRIME,
    HORROR,
    MAGIC

}
