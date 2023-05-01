package com.example.activity.di

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideTelephonyManager(context: Context): TelephonyManager {
        return context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    @Provides
    fun providePackageManager(context: Context): PackageManager {
        return context.packageManager
    }

    @Provides
    fun provideCallPermission(): String {
        return Manifest.permission.CALL_PHONE
    }
}