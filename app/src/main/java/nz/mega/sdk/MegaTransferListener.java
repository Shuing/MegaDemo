/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package nz.mega.sdk;

class MegaTransferListener {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected MegaTransferListener(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected static long getCPtr(MegaTransferListener obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                megaJNI.delete_MegaTransferListener(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    protected void swigDirectorDisconnect() {
        swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        swigCMemOwn = false;
        megaJNI.MegaTransferListener_change_ownership(this, swigCPtr, false);
    }

    public void swigTakeOwnership() {
        swigCMemOwn = true;
        megaJNI.MegaTransferListener_change_ownership(this, swigCPtr, true);
    }

    public void onTransferStart(MegaApi api, MegaTransfer transfer) {
        if (getClass() == MegaTransferListener.class)
            megaJNI.MegaTransferListener_onTransferStart(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer);
        else
            megaJNI.MegaTransferListener_onTransferStartSwigExplicitMegaTransferListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer);
    }

    public void onTransferFinish(MegaApi api, MegaTransfer transfer, MegaError error) {
        if (getClass() == MegaTransferListener.class)
            megaJNI.MegaTransferListener_onTransferFinish(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error);
        else
            megaJNI.MegaTransferListener_onTransferFinishSwigExplicitMegaTransferListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error);
    }

    public void onTransferUpdate(MegaApi api, MegaTransfer transfer) {
        if (getClass() == MegaTransferListener.class)
            megaJNI.MegaTransferListener_onTransferUpdate(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer);
        else
            megaJNI.MegaTransferListener_onTransferUpdateSwigExplicitMegaTransferListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer);
    }

    public void onTransferTemporaryError(MegaApi api, MegaTransfer transfer, MegaError error) {
        if (getClass() == MegaTransferListener.class)
            megaJNI.MegaTransferListener_onTransferTemporaryError(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error);
        else
            megaJNI.MegaTransferListener_onTransferTemporaryErrorSwigExplicitMegaTransferListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, MegaError.getCPtr(error), error);
    }

    public boolean onTransferData(MegaApi api, MegaTransfer transfer, byte[] buffer) {
        return (getClass() == MegaTransferListener.class) ? megaJNI.MegaTransferListener_onTransferData(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, buffer) : megaJNI.MegaTransferListener_onTransferDataSwigExplicitMegaTransferListener(swigCPtr, this, MegaApi.getCPtr(api), api, MegaTransfer.getCPtr(transfer), transfer, buffer);
    }

    public MegaTransferListener() {
        this(megaJNI.new_MegaTransferListener(), true);
        megaJNI.MegaTransferListener_director_connect(this, swigCPtr, swigCMemOwn, true);
    }

}
