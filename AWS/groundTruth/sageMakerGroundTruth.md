# Amazon SageMaker Ground Truth

## 1. Create workforce

![createPrivateTeam](../groundTruth/images/createPrivateTeam.png)

- SageMaker의 Labeling workforce에서 Create private team을 선택해 줍니다.
- 각 항목들을 입력하여 private 팀을 생성해 줍니다.

![privateTeam](../groundTruth/images/privateTeam.png)

- private team을 생성하면 다음과 같이 나옵니다.
- 메일로 들어가서 임시 password로 authorize를 해 줍니다.

![authorized](../groundTruth/images/authorized.png)
- 위와 같이 authorized로 바뀝니다.

## 2. Create a labeling job

이제 labeling을 해보겠습니다.

![labeling1](../groundTruth/images/labeling1.png)

- 레이블 지정 작업 생성으로 들어갑니다.

![labeling2](../groundTruth/images/labeling2.png)

- s3에 있는 파일로 할 수도, manifest file을 만들 수도 있습니다.

![s3-0](../groundTruth/images/s3-0.png)

- S3는 다음과 같은 세팅을 하였습니다.

![s3-1](../groundTruth/images/s3-1.png)

- 해당 버킷에 대한 액세스 요청을 모두 기록합니다.

![s3-2](../groundTruth/images/s3-2.png)

- 권한 설정도 우선 기본 사항으로 하였습니다.

![s3-3](../groundTruth/images/s3-3.png)

- 이렇게 S3 버킷을 생성했습니다.
- 그리고 샘플 dataset은 제 마음대로 넣어봤습니다.
- S3 버킷에 파일을 넣고 manifest를 생성해주어야 합니다.
- manifest 만들기는 다음을 참고합니다

https://docs.aws.amazon.com/ko_kr/sagemaker/latest/dg/sms-data-input.html#sms-console-create-manifest-file

https://docs.aws.amazon.com/sagemaker/latest/dg/sms-getting-started-step1.html

- manifest는 샘플들을 리스팅하는 json 파일인데 docs와 다르게 manifest 없이도 할 수 있도록 되어있습니다.

그리고 다시 labeling으로 돌아가

![labeling3](../groundTruth/images/labeling3.png)

- 이런식으로 세팅을 해 줍니다

![labeling4](../groundTruth/images/labeling4.png)

- dataset이 이미지들 이므로 task category는 image, task selection은 semantic segmentation으로 해보겠습니다.

다음으로 넘어가서

![labeling5](../groundTruth/images/labeling5.png)

- private으로 세팅해 줍니다.

![labeling6](../groundTruth/images/labeling6.png)

- 이런식으로 예시가 나옵니다
- 구분해야할 물체를 최대한 구체적으로 명시해줍니다.

![labeling7](../groundTruth/images/labeling7.png)

- 생성 버튼을 눌러주면 다음과 같이 labeling job이 생성 됩니다.

![labeling8](../groundTruth/images/labeling8.png)

- 들어가보면 작업 중인 사진들이 보입니다.
- 시간이 좀 걸리니 기다려야 합니다.

![labeling9](../groundTruth/images/labeling9.png)

- 굉장히 오래걸리는군요..4시간 정도 경과했습니다.