package com.szchoiceway.settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.os.storage.StorageManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.joanzapata.pdfview.PDFView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class ManualActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "ManualActivity";
    private String backupPath = ("/mnt/privdata1/" + this.pdfFolderName);
    /* access modifiers changed from: private */
    public View btnFloat1;
    /* access modifiers changed from: private */
    public View btnFloat2;
    /* access modifiers changed from: private */
    public boolean copyState = false;
    private File file;
    private boolean importFail = false;
    /* access modifiers changed from: private */
    public View importPdf2;
    private String[] list;
    private String localPath = ("/sdcard/" + this.pdfFolderName);
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    boolean unused = ManualActivity.this.copyState = true;
                    ManualActivity.this.mTips.setText(ManualActivity.this.getResources().getString(R.string.lbl_manual_importing));
                    return;
                case 101:
                    boolean unused2 = ManualActivity.this.copyState = false;
                    ManualActivity.this.mTips.setText(ManualActivity.this.getResources().getString(R.string.lbl_manual_import_success));
                    sendEmptyMessageDelayed(103, 5000);
                    return;
                case 102:
                    boolean unused3 = ManualActivity.this.copyState = false;
                    ManualActivity.this.mTips.setText(ManualActivity.this.getResources().getString(R.string.lbl_manual_import_not_found));
                    sendEmptyMessageDelayed(103, 5000);
                    return;
                case 103:
                    ManualActivity.this.mTips.setText("");
                    return;
                case 104:
                    ManualActivity.this.btnFloat1.setVisibility(0);
                    ManualActivity.this.btnFloat2.setVisibility(0);
                    ManualActivity.this.importPdf2.setVisibility(8);
                    return;
                case 105:
                    ManualActivity.this.btnFloat1.setVisibility(8);
                    ManualActivity.this.btnFloat2.setVisibility(8);
                    ManualActivity.this.importPdf2.setVisibility(0);
                    sendEmptyMessageDelayed(104, 5000);
                    return;
                case 106:
                    boolean unused4 = ManualActivity.this.copyState = false;
                    ManualActivity.this.mTips.setText(ManualActivity.this.getResources().getString(R.string.lbl_manual_import_fail));
                    sendEmptyMessageDelayed(103, 5000);
                    return;
                case 107:
                    ManualActivity.this.mTips.setText(ManualActivity.this.getResources().getString(R.string.lbl_manual_open_not_found));
                    sendEmptyMessageDelayed(103, 5000);
                    return;
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    public TextView mTips;
    private String oldPath = "";
    private String pdfFolderName = "UserManual/";
    private String pdfName = "";
    private PDFView pdfView;
    private View viewPdf;
    private View viewTips;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "onCreate");
        showSystermTitleBar(false);
        setContentView(R.layout.kesaiwei_1920x720_activity_manual);
        this.list = new String[]{"English: manual.pdf", "中文简体: manual_zh-CN.pdf", "中文繁體: manual_zh-TW.pdf", "العربية: manual-ar.pdf", "Deutsch: manual-de.pdf", "Ελληνικά: manual-el.pdf", "Español: manual-es.pdf", "Français: manual-fr.pdf", "Italiano: manual-it.pdf", "עִברִית: manual-iw.pdf", "日本語: manual-ja.pdf", "한국인: manual-ko.pdf", "Nederlands: manual-nl.pdf", "Polski: manual-pl.pdf", "Português: manual-pt.pdf", "русский: manual-ru.pdf", "ไทย: manual-th.pdf", "Türkçe: manual-tr.pdf", "Tiếng Việt: manual-vi.pdf"};
        this.viewTips = findViewById(R.id.viewTips);
        this.viewPdf = findViewById(R.id.viewPdf);
        this.pdfView = (PDFView) findViewById(R.id.pdfView);
        initPdf();
        View findViewById = findViewById(R.id.openPdf);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.importPdf);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        View findViewById3 = findViewById(R.id.importPdf2);
        this.importPdf2 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
            this.importPdf2.setVisibility(8);
        }
        View findViewById4 = findViewById(R.id.btnFloat1);
        this.btnFloat1 = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this);
            this.btnFloat1.setVisibility(0);
        }
        View findViewById5 = findViewById(R.id.btnFloat2);
        this.btnFloat2 = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(this);
            this.btnFloat2.setVisibility(0);
        }
        ((GridView) findViewById(R.id.gridView)).setAdapter(new ArrayAdapter(this, R.layout.manual_grid_item, this.list));
        TextView textView = (TextView) findViewById(R.id.tips);
        this.mTips = textView;
        if (textView != null) {
            textView.setText("");
        }
    }

    public void onClick(View view) {
        if (!this.copyState) {
            switch (view.getId()) {
                case R.id.btnFloat1 /*2131230976*/:
                case R.id.btnFloat2 /*2131230977*/:
                    this.mHandler.sendEmptyMessage(105);
                    return;
                case R.id.importPdf /*2131231189*/:
                    startImportThread();
                    return;
                case R.id.importPdf2 /*2131231190*/:
                    this.viewTips.setVisibility(0);
                    this.viewPdf.setVisibility(8);
                    return;
                case R.id.openPdf /*2131231313*/:
                    initPdf();
                    return;
                default:
                    return;
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    private void showSystermTitleBar(boolean z) {
        if (!z) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags |= 1024;
            getWindow().setAttributes(attributes);
            getWindow().addFlags(512);
            return;
        }
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.flags &= -1025;
        getWindow().setAttributes(attributes2);
        getWindow().clearFlags(512);
    }

    private void initPdf() {
        this.pdfName = this.list[0];
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        Log.i(TAG, "--->>> lan = " + language + ", country = " + country);
        if (language.equals("zh") && country.equals("CN")) {
            this.pdfName = this.list[1].split(":")[1].trim();
        } else if (language.equals("zh") && country.equals("TW")) {
            this.pdfName = this.list[2].split(":")[1].trim();
        } else if (language.equals("en")) {
            this.pdfName = this.list[0].split(":")[1].trim();
        } else if (language.equals("ar")) {
            this.pdfName = this.list[3].split(":")[1].trim();
        } else if (language.equals("de")) {
            this.pdfName = this.list[4].split(":")[1].trim();
        } else if (language.equals("el")) {
            this.pdfName = this.list[5].split(":")[1].trim();
        } else if ("es".equals(language)) {
            this.pdfName = this.list[6].split(":")[1].trim();
        } else if ("fr".equals(language)) {
            this.pdfName = this.list[7].split(":")[1].trim();
        } else if ("it".equals(language)) {
            this.pdfName = this.list[8].split(":")[1].trim();
        } else if ("iw".equals(language)) {
            this.pdfName = this.list[9].split(":")[1].trim();
        } else if ("ja".equals(language)) {
            this.pdfName = this.list[10].split(":")[1].trim();
        } else if ("ko".equals(language)) {
            this.pdfName = this.list[11].split(":")[1].trim();
        } else if ("nl".equals(language)) {
            this.pdfName = this.list[12].split(":")[1].trim();
        } else if ("pl".equals(language)) {
            this.pdfName = this.list[13].split(":")[1].trim();
        } else if ("pt".equals(language)) {
            this.pdfName = this.list[14].split(":")[1].trim();
        } else if ("ru".equals(language)) {
            this.pdfName = this.list[15].split(":")[1].trim();
        } else if ("th".equals(language)) {
            this.pdfName = this.list[16].split(":")[1].trim();
        } else if ("tr".equals(language)) {
            this.pdfName = this.list[17].split(":")[1].trim();
        } else if ("vi".equals(language)) {
            this.pdfName = this.list[18].split(":")[1].trim();
        }
        File file2 = new File("/sdcard/UserManual/" + this.pdfName);
        this.file = file2;
        if (!file2.exists()) {
            this.pdfName = this.list[0].split(":")[1].trim();
            this.file = new File("/sdcard/UserManual/" + this.pdfName);
        }
        Log.d(TAG, "file path = " + this.file.getPath() + ", file exist " + this.file.exists());
        if (!this.file.exists() || this.file.length() <= 0) {
            this.mHandler.sendEmptyMessage(107);
            return;
        }
        View view = this.viewTips;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.viewPdf;
        if (view2 != null) {
            view2.setVisibility(0);
            this.mHandler.removeMessages(104);
            this.mHandler.removeMessages(105);
            this.mHandler.sendEmptyMessage(105);
            this.pdfView.fromFile(this.file).defaultPage(1).onPageChange($$Lambda$ManualActivity$Ei9naQ_Zavi9LjOwPcMPp8sL_tA.INSTANCE).enableSwipe(true).load();
        }
    }

    private void startImportThread() {
        new Thread(new Runnable() {
            public final void run() {
                ManualActivity.this.lambda$startImportThread$1$ManualActivity();
            }
        }).start();
    }

    public /* synthetic */ void lambda$startImportThread$1$ManualActivity() {
        this.mHandler.sendEmptyMessage(100);
        getPath();
        if (this.oldPath.length() > 0) {
            copyFolder(this.oldPath, this.localPath);
            runCmd("chmod 777 /mnt/privdata1/");
            do {
            } while (getCmdResult());
            copyFolder(this.oldPath, this.backupPath);
        } else {
            this.mHandler.sendEmptyMessage(102);
        }
        if (!this.importFail) {
            this.mHandler.sendEmptyMessage(101);
        }
    }

    public void copyFolder(String str, String str2) {
        try {
            File file2 = new File(str2);
            if (file2.exists() && file2.isDirectory()) {
                for (File delete : file2.listFiles()) {
                    delete.delete();
                }
            }
            Log.d(TAG, "delete " + str2 + " " + file2.delete());
            Log.d(TAG, "mk = " + file2.mkdir());
            for (File file3 : new File(str).listFiles()) {
                ksw_Copy_File(file3.getAbsolutePath(), str2 + file3.getName());
            }
        } catch (Exception e) {
            Log.d(TAG, "复制整个文件夹内容操作出错");
            this.importFail = true;
            this.mHandler.sendEmptyMessage(106);
            e.printStackTrace();
        }
    }

    public boolean ksw_Copy_File(String str, String str2) {
        Log.d(TAG, "copyFile oldPath = " + str + ", newPath = " + str2);
        boolean z = true;
        try {
            File file2 = new File(str);
            File file3 = new File(str2);
            Log.i(TAG, "--->>> olderPath = 000");
            if (file3.exists()) {
                Log.i(TAG, "--->>> olderPath = 111");
                file3.delete();
            }
            file3.createNewFile();
            if (file2.exists()) {
                Log.i(TAG, "--->>> olderPath = 222");
                FileInputStream fileInputStream = new FileInputStream(str);
                Log.i(TAG, "--->>> olderPath = 333");
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                Log.i(TAG, "--->>> olderPath = 444");
                byte[] bArr = new byte[12288];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Log.i(TAG, "--->>> olderPath = 555");
                fileOutputStream.flush();
                fileOutputStream.close();
                fileInputStream.close();
            } else {
                z = false;
            }
            return z;
        } catch (Exception e) {
            this.importFail = true;
            this.mHandler.sendEmptyMessage(106);
            e.printStackTrace();
            return false;
        }
    }

    private void getPath() {
        String[] strArr;
        StorageManager storageManager = (StorageManager) getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumePaths", new Class[0]);
            method.setAccessible(true);
            try {
                strArr = (String[]) method.invoke(storageManager, new Object[0]);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                strArr = null;
            }
            if (strArr != null) {
                if (strArr.length > 0) {
                    for (int i = 0; i < strArr.length; i++) {
                        Log.d(TAG, "path----> " + strArr[i] + "\n");
                        String str = "";
                        if (!"/storage/emulated/0".equals(strArr[i])) {
                            str = strArr[i] + "/" + this.pdfFolderName;
                        }
                        Log.d(TAG, "path = " + str);
                        File file2 = new File(str);
                        if (file2.exists() && file2.isDirectory()) {
                            this.oldPath = str;
                        }
                    }
                }
            }
            Log.d(TAG, "oldPath = " + this.oldPath);
            if (this.oldPath.length() == 0) {
                this.importFail = true;
            }
        } catch (Exception e2) {
            this.importFail = true;
            e2.printStackTrace();
        }
    }

    public void runCmd(String str) {
        SystemProperties.set("sys.apk_path", str);
        SystemProperties.set("ctl.start", "install_apk");
    }

    public boolean getCmdResult() {
        return SystemProperties.get("sys.apk_path").equals("true");
    }
}
