wlc-fire-tv-app
===============

## 1.

```bash
adb kill-server
adb start-server
adb connect 192.168.178.77
```

## 2.

```bash
Q:
cd "Q:\dev\projects\welovecoding\wlc-fire-tv-app"
ant clean debug
adb install -r "out/production/wlc-fire-tv-app/wlc-fire-tv-app.apk"
adb shell am start -n com.welovecoding.app.firetv/.MyMainActivity
```
