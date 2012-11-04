import org.apache.shiro.crypto.hash.Sha256Hash
import com.gap.shiro.User

class BootStrap {

    def init = { servletContext ->
		def user = new User(username: "Admin", passwordHash: new Sha256Hash("Access4admin").toHex())
		user.addToPermissions("*:*")
		user.save()
    }
    def destroy = {
    }
}
