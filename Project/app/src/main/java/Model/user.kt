package Model
import java.util.*

/**
 * Created by shehab on 3/29/18.
 */

    open class user() {
        constructor(uname:String, psswd:String, mail:String, phone:String,
                    fName:String,mName:String, lName:String, bdate:String, gender:Char, bhvRate:Int,
                    imgid:String) : this() {
            userName=uname;password=psswd;email=mail;phoneNum=phone
            firstName=fName;midName=mName;lastName=lName;birthDate=bdate;this.gender=gender
            behaveRate=bhvRate;imageID=imgid
        }
        var userName: String = ""
            set(value) {
                field = value
            }
        var password: String = ""
            set(value) {
                field = value
            }
        var email: String = ""
            set(value) {
                field = value
            }
        var phoneNum: String = ""
            set(value) {
                field = value
            }
        var firstName: String = ""
            set(value) {
                field = value
            }
        var midName: String = ""
            set(value) {
                field = value
            }
        var lastName: String = ""
            set(value) {
                field = value
            }
        var birthDate: String = ""
            set(value) {
                field = value
            }

        var gender: Char = ' '
            set(value) {
                field = value
            }
        var behaveRate: Int = 5
            set(value) {
                field = when {
                    value > 10 -> 10
                    value < 0 -> 0
                    else -> value }
            }
        var imageID: String = ""
        companion object {
            val userNameKey: String = "userName"
            val passwordKey: String = "password"
            val firstNameKey: String = "firstName"
            val midNameKey: String = "midName"
            val lastNameKey: String = "lastName"
            val birthDateKey: String = "birthDate"
            val emailKey: String = "eMail"
            val genderKey: String = "gender"
            val imageKey: String = "image"
            val behaveRateKey: String = "behaveRate"
            val phoneNumKey: String = "phoneNumber"
            val professionCollectionKey: String = "profession"
            val notificationsCollectionKey: String = "notifications"
            val postsCollectionKey:String = "posts"
            val usersCollectionName:String = "user"
        }
    }

