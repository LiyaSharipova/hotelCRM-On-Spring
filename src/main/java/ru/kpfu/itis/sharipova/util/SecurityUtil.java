package ru.kpfu.itis.sharipova.util;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.itis.sharipova.model.Credentials;

/**
 * Created by lia on 27.05.16.
 */
public class SecurityUtil {
    public static Credentials getCurrentUser() {
        return ((Credentials) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
