package de.blogspot.mszalbach.iss.audit;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by ms on 12.12.16.
 */
public class SecurityRevisionListener
        implements RevisionListener {

    public static final String NO_USER_DETAILS = "UNKOWN";



    @Override
    public void newRevision( Object revisionEntity ) {

        SecurityRevisionEntity securityRevisionEntity = ( SecurityRevisionEntity )revisionEntity;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ( authentication != null ) {
            securityRevisionEntity.setUsername( authentication.getName() );
            securityRevisionEntity.setRoles( authentication.getAuthorities().toString() );
        } else {
            securityRevisionEntity.setUsername( NO_USER_DETAILS );
            securityRevisionEntity.setRoles( NO_USER_DETAILS );
        }
    }
}
