package akshay.galleyview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.indi.view.*
import java.io.File

class Myadapter : BaseAdapter {

    var files : Array<File>? = null
    var activity : MainActivity? = null

    constructor(activity: MainActivity) {
        var path = "/storage/sdcard0/WhatsApp/Media/WhatsApp Video/"
        var file = File(path)
        if (!file.exists()){
            path="/storage/emulated/0/WhatsApp/Media/WhatsApp Video/"
            file = File(path)
        }
        var files = file.listFiles()

        this.files = files
        this.activity = activity
    }



    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inf = LayoutInflater.from(activity)
        var v =inf.inflate(R.layout.indi,null)
        var vfile = files!![p0]



        v.vv.setVideoURI(Uri.fromFile(vfile))


        v.cb.text = vfile.name

        v.cb.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                v.vv.start()
            }
            else{
                v.vv.resume()
            }
        }
        return v

    }

    override fun getItem(p0: Int): Any {
    return 0
    }

    override fun getItemId(p0: Int): Long {
    return 0
    }

    override fun getCount(): Int {
        return files!!.size
    }

}