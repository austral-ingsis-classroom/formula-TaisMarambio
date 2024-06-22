package edu.austral.ingsis.math.visitor;

public class Variable implements Visitable{
  private int value;
  private final String variable;

  public Variable(int value) {
    this.value = value;
    this.variable="";
  }

  public Variable(String variable, int value){
    this.variable = variable;
    this.value = value;
  }

  public Variable(String variable) {
    this.variable = variable;
  }

  public boolean isVariable(){
    return !variable.isEmpty();
  }


  public double getValue() {
    return value;
  }

  public String print(){
    if(!variable.isEmpty()){
      return variable;
    } else{
      return String.valueOf(value);
    }
  }

  @Override
  public <T> T accept(Visitor<T> visitor) {
    return visitor.visit(this);
  }
}