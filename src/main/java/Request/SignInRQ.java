package Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignInRQ {
    private String deviceId;
    private String signUpType;
    private String accessToken;
    private String appleCode;
    private String language;
    private String fromIOS;
    private String authorizationCodeZalo;
    private String codeVerifierZalo;
    private String email;
    private String password;
}
