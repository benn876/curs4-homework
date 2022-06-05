package ex3;

public sealed interface Bird extends Animal permits Canary,Parrot,Chicken {
}
