package Model.postData.Comment

class comment(var id: Int, var isImportant: Boolean, var picture: String,
              var from: String, var subject: String, var message: String,
              var timestamp: String, var isRead: Boolean,var color:Int, var deleteIt:Boolean=false)