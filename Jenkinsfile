#!groovy

pipeline {
    agent   any

    stages {
         stage('SERVICES TEST 1'){
             steps {
                 script{
                    try{
                    echo "[EXEC] - Services Test 1"
                    sh "newman run pruebas-postman.postman_collection.json -n 2 delay-request 2000"
                    currentBuild.result = "SUCCESS"
                    }catch(err) {
                        echo "Error al ejecutar test1"
                        currentBuild.result = "FAILURE"
                    } finally{
                        mail to: "${EMAIL_REPORTE}",
                        subject: "Finally"
                        Body: "Ejecucion de pruebas Postman ${currentBuild.result}"
                    }
                 }
             }
         }
    }

}