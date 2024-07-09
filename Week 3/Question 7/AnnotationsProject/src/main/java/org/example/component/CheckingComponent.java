package org.example.component;

import org.springframework.stereotype.Component;

@Component
public class CheckingComponent {

    public boolean check(int id) {
        return id % 2 == 0;
    }
}
