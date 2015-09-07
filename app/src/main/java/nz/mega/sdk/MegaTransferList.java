/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package nz.mega.sdk;

public class MegaTransferList {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected MegaTransferList(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected static long getCPtr(MegaTransferList obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    protected synchronized void delete() {
        if (swigCPtr != 0) {
            if (swigCMemOwn) {
                swigCMemOwn = false;
                megaJNI.delete_MegaTransferList(swigCPtr);
            }
            swigCPtr = 0;
        }
    }

    public MegaTransfer get(int i) {
        long cPtr = megaJNI.MegaTransferList_get(swigCPtr, this, i);
        return (cPtr == 0) ? null : new MegaTransfer(cPtr, false);
    }

    public int size() {
        return megaJNI.MegaTransferList_size(swigCPtr, this);
    }

}
