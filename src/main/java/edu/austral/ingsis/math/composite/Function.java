package edu.austral.ingsis.math.composite;

import java.util.List;

public interface Function {
  double evaluate();
  String print();
  List<String> listVariables(List<String> list);
}