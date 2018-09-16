package learning.javacore;

import java.util.ArrayList;
import java.util.List;

public class InterfaceIn8Java {
}


interface Animal { public default String getName() { return null; } }
interface Mammal { public default String getName() { return null; } }
//abstract class Otter implements Mammal, Animal { }

