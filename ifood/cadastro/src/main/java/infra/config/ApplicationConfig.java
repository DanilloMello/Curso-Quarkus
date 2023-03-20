package infra.config;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
@LoginConfig(authMethod = "MP-JWT")
@ApplicationPath("/")
@DeclareRoles({"trainer","USER"})
public class ApplicationConfig extends Application {

}
