package coercedclosures

new File('/').list({
    File dir, String name -> File(name).directory
}).each { fileName -> println fileName }