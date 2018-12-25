package com.zy.wanandroid.net

import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
import okio.ForwardingSource
import okio.Okio


open class DownloadResponseBody : ResponseBody {

    private var originalResponse: Response? = null
    private var downloadListener: DownloadListener? = null
    private var oldPoint: Long = 0

    constructor(originalResponse: Response, downloadListener: DownloadListener?, oldPoint: Long) {
        this.originalResponse = originalResponse
        this.downloadListener = downloadListener
        this.oldPoint = oldPoint
    }

    override fun contentLength(): Long {
        return originalResponse!!.body()!!.contentLength()
    }

    override fun contentType(): MediaType? {
        return originalResponse!!.body()!!.contentType()
    }

    override fun source(): BufferedSource {

        return Okio.buffer(object : ForwardingSource(originalResponse!!.body()!!.source()) {
            var bytesReaded: Long = 0
            override fun read(sink: Buffer, byteCount: Long): Long {

                val bytesRead = super.read(sink, byteCount)
                bytesReaded += bytesRead
                if (bytesReaded.toInt() == -1) {
                    0
                } else {
                    bytesRead
                }
                if (downloadListener != null) {
                    downloadListener!!.loading(((bytesReaded + oldPoint) / 1024))
                }
                return super.read(sink, byteCount)
            }
        })
    }


}