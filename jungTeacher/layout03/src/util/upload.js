///
/// 파일 업로드를 위한 Composable 모듈
///

import { requestConfig } from '../../app.config.js';

export const useUpload = () => {

    ///
    /// 파일 업로드를 위한 함수
    ///
    const upload = async (selectedFile, progressCallback) => {
        
        return new Promise(async (resolve, reject) => {
            console.log(`upload 호출됨 -> name : ${selectedFile.name}, type : ${selectedFile.type}`);

            try { 
                let formData = new FormData();
                formData.append("photo", selectedFile);
            
                const response = await axios.post(
                    `${requestConfig.baseUrl}/profile/upload`,
                    formData, 
                    {
                        headers: {
                            'Content-Type':'multipart/form-data;charset=utf-8;'
                        },
                        onUploadProgress: (event) => {
                            const progress = parseInt((event.loaded/event.total)*100)
                            
                            if (progressCallback) {
                                progressCallback(progress);
                            }
                        }
                    }
                )
          
                resolve(response.data);
          
            } catch(err) {
                console.error(`에러 -> ${err}`);
                
                reject(`에러 -> ${err}`);
            }
        })
    }

    return { upload }
}