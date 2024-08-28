package com.github.rodmotta.petshop.v2.core.shared;

public interface UseCase<INPUT, OUTPUT> {
    OUTPUT execute(INPUT input);
}
