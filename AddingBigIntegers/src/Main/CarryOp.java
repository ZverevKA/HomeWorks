package Main;

public class CarryOp {


    public static Carry getIdentityElement() {
        return Carry.M;
    }

    public static Carry composition(Carry a, Carry b) {
        if (a == Carry.N && b == Carry.N) {
            return Carry.N;
        }
        if (a == Carry.N && b == Carry.M) {
            return Carry.N;
        }
        if (a == Carry.N && b == Carry.C) {
            return Carry.C;
        }
        if (a == Carry.M && b == Carry.N) {
            return Carry.N;
        }
        if (a == Carry.M && b == Carry.M) {
            return Carry.M;
        }
        if (a == Carry.M && b == Carry.C) {
            return Carry.C;
        }
        if (a == Carry.C && b == Carry.N) {
            return Carry.N;
        }
        if (a == Carry.C && b == Carry.M) {
            return Carry.C;
        }
            return Carry.C;  // C and C case
    }
}
