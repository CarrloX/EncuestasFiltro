package com.riwi.encuestas.domain.entity;

import java.util.List;

import com.riwi.encuestas.utils.enums.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String question_id;
    private String text;
    @Column(nullable = false, length = 50)
    private Type type;
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", referencedColumnName = "survey_id")
    private SurveyEntity survey;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<OptionQuestion> optionQuestions;
}
