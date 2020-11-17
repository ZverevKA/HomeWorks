package Parallel;

public interface ConvertableToCompositionable<T,X> { // it helps to arbitrary output data processing
    Compositionable<X> ConvertToCompositionable(T a);
}
