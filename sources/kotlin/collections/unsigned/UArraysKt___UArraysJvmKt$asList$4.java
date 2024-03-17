package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$4", "Lkotlin/collections/AbstractList;", "Lkotlin/UShort;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-xj2QHRw", "(S)Z", "get", "index", "get-Mh2AYeg", "(I)S", "indexOf", "indexOf-xj2QHRw", "(S)I", "isEmpty", "lastIndexOf", "lastIndexOf-xj2QHRw", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: _UArraysJvm.kt */
public final class UArraysKt___UArraysJvmKt$asList$4 extends AbstractList<UShort> implements RandomAccess {
    final /* synthetic */ short[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$4(short[] sArr) {
        this.$this_asList = sArr;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UShort)) {
            return false;
        }
        return m500containsxj2QHRw(((UShort) obj).m336unboximpl());
    }

    public /* bridge */ /* synthetic */ Object get(int i) {
        return UShort.m281boximpl(m501getMh2AYeg(i));
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof UShort)) {
            return -1;
        }
        return m502indexOfxj2QHRw(((UShort) obj).m336unboximpl());
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof UShort)) {
            return -1;
        }
        return m503lastIndexOfxj2QHRw(((UShort) obj).m336unboximpl());
    }

    public int getSize() {
        return UShortArray.m345getSizeimpl(this.$this_asList);
    }

    public boolean isEmpty() {
        return UShortArray.m347isEmptyimpl(this.$this_asList);
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public boolean m500containsxj2QHRw(short s) {
        return UShortArray.m340containsxj2QHRw(this.$this_asList, s);
    }

    /* renamed from: get-Mh2AYeg  reason: not valid java name */
    public short m501getMh2AYeg(int i) {
        return UShortArray.m344getMh2AYeg(this.$this_asList, i);
    }

    /* renamed from: indexOf-xj2QHRw  reason: not valid java name */
    public int m502indexOfxj2QHRw(short s) {
        return ArraysKt.indexOf(this.$this_asList, s);
    }

    /* renamed from: lastIndexOf-xj2QHRw  reason: not valid java name */
    public int m503lastIndexOfxj2QHRw(short s) {
        return ArraysKt.lastIndexOf(this.$this_asList, s);
    }
}
