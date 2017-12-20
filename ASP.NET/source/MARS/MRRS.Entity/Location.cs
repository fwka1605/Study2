using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MRRS.Entity
{
    public class Location
    {
        public int LocationId { get; set; }
        public string LocationName { get; set; }

        public virtual ICollection<MeetingRoom> MeetingRooms { get; set; }  // (1)
    }
}
