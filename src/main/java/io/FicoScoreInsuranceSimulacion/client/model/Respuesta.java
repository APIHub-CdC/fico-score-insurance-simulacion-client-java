package io.FicoScoreInsuranceSimulacion.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.FicoScoreInsuranceSimulacion.client.model.Razon;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Datos de la respuesta de FICO Score")
public class Respuesta {
  @SerializedName("score")
  private Integer score = null;
  @SerializedName("razones")
  private List<Razon> razones = new ArrayList<Razon>();
  public Respuesta score(Integer score) {
    this.score = score;
    return this;
  }
   
  @ApiModelProperty(required = true, value = "Calificación que obtuvo la persona evaluada")
  public Integer getScore() {
    return score;
  }
  public void setScore(Integer score) {
    this.score = score;
  }
  public Respuesta razones(List<Razon> razones) {
    this.razones = razones;
    return this;
  }
  public Respuesta addRazonesItem(Razon razonesItem) {
    this.razones.add(razonesItem);
    return this;
  }
   
  @ApiModelProperty(required = true, value = "Razones por las que se generó el score")
  public List<Razon> getRazones() {
    return razones;
  }
  public void setRazones(List<Razon> razones) {
    this.razones = razones;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Respuesta respuesta = (Respuesta) o;
    return Objects.equals(this.score, respuesta.score) &&
        Objects.equals(this.razones, respuesta.razones);
  }
  @Override
  public int hashCode() {
    return Objects.hash(score, razones);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Respuesta {\n");
    
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    razones: ").append(toIndentedString(razones)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
